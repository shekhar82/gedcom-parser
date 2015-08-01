# gedcom-parser
This program is written to parse a GEDCOM text file and generate corresponding XML.

Highlight if the design:
1: Used TDD aproach
2: Used SOLID principles.
3: Used Maven for build
4: Used Java 8



Steps to run this program:

1: run following command first
  mvn clean install
2: To try out this program with internal gedcom text resource then run
  mvn exec:java -Dexec.mainClass="com.aconex.gedcom.GedcomParser"
3: To run your GEDCOM txt file, please run following commands:
  mvn exec:java -Dexec.mainClass="com.aconex.gedcom.GedcomParser" -Dexec.args="/Users/gupsh09/GEDCOM.txt”
  
  Plese make sure that you are using Java 8 to run this program. I have used Java 8 to compile this program.
  
