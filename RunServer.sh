#check this link to relearn maven details
#https://stackoverflow.com/questions/16602017/how-are-mvn-clean-package-and-mvn-clean-install-different

#delete all compiled maven files (the target folder) and rebuild them
mvn clean install

#create maven wrapper for latest maven version
mvn -N io.takari:maven:wrapper

#run the project jar
java -jar target/restAPI-0.0.1-SNAPSHOT.jar
