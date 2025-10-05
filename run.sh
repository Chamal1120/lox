#!/bin/bash

# Run
mvn -q -DskipTests compile

#java -cp target/classes com.craftinginterpreters.tool.GenerateAst com/craftinginterpreters/lox/
java -cp target/classes com.craftinginterpreters.lox.AstPrinter
#java -cp target/classes com.craftinginterpreters.lox.Lox test.lox
