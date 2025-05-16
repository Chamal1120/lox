package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
  static boolean hadError = false;
  // Main function
  public static void main(String[] args) throws IOException{

    // Validate the args from the stdin and run the lexer
    if (args.length > 1) {
      System.out.println("Usage: jlox [Script]");
      System.exit(64);
    } else if (args.length == 1){
      // Run the code in the file
      runFile(args[0]);
    } else {
      // Start the prompt
      runPrompt();
    }
  }

  // Run the code in the given file
  private static void runFile(String path) throws IOException {
    // Read as a bytestream
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    // Stringify and pass the code to run
    run(new String(bytes, Charset.defaultCharset()));
    if (hadError) System.exit(65);
  }

  // Start the prompt for the REPL
  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    // Loop the REPL
    for (;;) {
      System.out.print("> ");
      String line = reader.readLine();
      if (line == null) break;
      run(line);
      hadError = false;
    }
  }

  // Run the code (or ig this is the interpreter)
  private static void run(String source) {
    Scanner scanner = new Scanner(source);
    List<Token> tokens = scanner.scanTokens();

    // For now we just print the tokens
    for (Token token: tokens) {
      System.out.println(token);
    }
  }

  // Error handler function
  static void error(int line, String message) {
    report(line, "" , message);
  }

  // Error reporter function
  private static void report(int line, String where, String message) {
    System.err.println("[line " + line + "] Error" + where + ": " + message);
    hadError = true;
  }

}
