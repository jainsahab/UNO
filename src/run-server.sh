echo  "Enter Number Of Players"
read noOfPlayers
echo  "Enter Number Of Packs"
read noOfCards
echo "You entered $noOfPlayers and $noOfCards"
java -cp "../lib/*" com.step.programs.ServerApp $noOfPlayers $noOfCards