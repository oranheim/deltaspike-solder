deltaspike-solder
=================

The DeltaSpike Solder project is based on Seam and Solder version 3.2.0-SNAPSHOT. This project is different than others,
because normally you would add features to a project. As Apache DeltaSpike Incubation is growing and picking up
features found in Seam 3.1, this project will diminish, hopefully to zero code.

Build
-----

1. cd parent
2. mvn clean install
3. cd ..
4. mvn clean install -DskipTests

See if it works
----------

You can try Seam Mail testsuite by:

1. cd mail/testsuite
2.1. mvn clean test -Pweld-ee-embedded-1.1 

or

2.2. mvn clean test -Premote


Try it out
-----

* Fork and build
* Read through Apache DeltaSpike documentation
* In your project Update seam-parent to version `20ds-SNAPSHOT`
* In your project Update seam-bom to version `3.5.0-SNAPSHOT`


Disclaimer
-----

* This project is only intended to work with Weld and JBoss AS 7.1+
* The soul purpose of this project is to act as a glue layer for DeltaSpike during porting of Seam 3.1 

### Change-log

* Solder was forked on 2012-09-02 16:58 GMT+1
* Seam Mail was forked on 2012-09-02 13:57 GMT+1

Enjoy!

Kind regards,
Ove Ranheim
(oranheim at gmail com)
