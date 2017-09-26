#Impact Integration - React
###Development
To run the program for development, simply run the main under ImpactIntegrationApplication. Be sure to set a vm arg to `-Dspring.profiles.active-dev`

As well, you will need to run `npm run dev` from the root directory in order to serve up the statics

###Production
Command to run the output of gradle locally:  
`java -jar build/libs/petfinder-site-1.0-SNAPSHOT.jar --spring.profiles.active=qa`