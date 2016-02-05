cd DiabetesAssistant

echo "Clean & Build"
JAVA_HOME=/usr/lib/jvm/default-java ~/.netbeans/8.0/maven/bin/mvn -f ~/Projects/DiabetesAssistant/DiabetesAssistant/pom.xml clean install

echo "Generate PIT -report"
mvn test org.pitest:pitest-maven:mutationCoverage

echo "Generate Checkstyle -report"
mvn jxr:jxr checkstyle:checkstyle

echo "Remove old PIT -reports..."
rm -rfv ../dokumentointi/pit/*

echo "Remove old Checkstyle -report..."
rm -rfv ../dokumentointi/checkstyle/*

echo "Copy new PIT -reports..."
cd target/pit-reports/*
cp -R * ../../../../dokumentointi/pit/
cd ../../site

echo "Copy new Checkstyle -report..."
cp -R * ../../../dokumentointi/checkstyle/

if ! [ -z "$1" ]
  then
    cd ../../../../
    git add --all; git commit -a -m "PIT updated"; git push;
fi
