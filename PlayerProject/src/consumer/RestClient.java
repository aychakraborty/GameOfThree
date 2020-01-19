package consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

import model.Player;

public class RestClient {
	public static void main(String[] args) {
		try {
			Player player1 = new Player(1, "Player1"); // Player 1
			Player player2 = new Player(2, "Player2"); // Player 2

			Random random = new Random();
			Integer randomNumber = random.nextInt(100); // Generate a random number between 0 to 100
			while (randomNumber < 2) {
				// If random number generated is less than 2, then re-generate it again
				randomNumber = random.nextInt(100);
			}

			String response = null;
			String player = player1.getName(); // Letting Player 1 start first

			do {
				if (randomNumber > 1) {
					// Console output of the game change
					System.out.println("Current Player: " + player + " -> Sending Number: " + randomNumber);
				}
				response = restApiCall(randomNumber, player); // Calling REST Api to receive the number after
																// calculation
				if (response != null) {
					if (Integer.parseInt(response) != 1) { // If the response number is 1, do not change player's name
						System.out.print("Is the other player ready? (Y/N): ");
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						String readyResponse = reader.readLine();
						if (readyResponse.equals("Y")) { // Check if other player is ready, if not then same player
															// continues playing
							// Change player's name once response is received
							if (player.equals(player1.getName())) {
								player = player2.getName();
							} else {
								player = player1.getName();
							}
						}
					}
					randomNumber = Integer.parseInt(response); // Assign {response} to {randomNumber} to keep the game
																// going
				}
			} while (randomNumber >= 1); // Keep the game going until {response} = 1

			System.out.println();
			System.out.println("WINNER:: " + player); // Console output the winner

		} catch (Exception e) {
			System.out.println("REST API is down. Please start the API on server.");
		}
	}

	private static String restApiCall(Integer randomNumber, String player)
			throws MalformedURLException, IOException, ProtocolException {
		// Create the URL
		URL url = new URL(
				"http://localhost:8080/GameOfThree/rest/PlayerService/numbers/" + player + "/" + randomNumber);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Open connection
		conn.setRequestMethod("GET");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
		}
		// Receive the response
		InputStreamReader in = new InputStreamReader(conn.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String response = null;
		while ((response = br.readLine()) != null) {
			return response;
		}
		conn.disconnect(); // Close the connection
		return response;
	}
}
