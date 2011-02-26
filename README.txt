GameTable
  Players sit at tables to play card games.
  Each table has one type of game.
  Game rules are in XML format, are parsed into OX-C-GEN.
  The table places the cards based on player commands, validating against the rules.  No cheating!
  The table keeps score (if any) and updates the backend score database.
  
  The table exists on the server and on the client, but the final word goes to the one on the server.

GameSeat
  Tables have a set number of seats (dependent on the game being played) which represent the places players sit to play.

GameRules
  