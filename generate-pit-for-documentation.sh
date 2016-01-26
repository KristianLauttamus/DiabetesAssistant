cd DiabetesAssistant

echo "Clean & Build"
JAVA_HOME=/usr/lib/jvm/default-java /home/krislaut/.netbeans/8.0/maven/bin/mvn -f /home/krislaut/DiabetesAssistant/DiabetesAssistant/pom.xml clean install

echo "Generate PIT -test"
mvn test org.pitest:pitest-maven:mutationCoverage

echo "Remove old PIT -reports..."
rm -rfv ../dokumentointi/pit/*

echo "Copy new PIT -reports..."
cd target/pit-reports/*
cp -R * ../../../../dokumentointi/pit/
