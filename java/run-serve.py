#!/usr/bin/env python3
import os # for python api to os
import subprocess as sp # for sp.call to literally execute


def print_hella_stars(n):
    for i in range(n):
        print("*"*50)

if ("pom.xml" in os.listdir()):
    print_hella_stars(1)
    print("mvn compile","."*38)
    print_hella_stars(1)
    sp.call(["mvn", "compile"])
    print_hella_stars(5)
    print("mvn package","."*38)
    print_hella_stars(1)
    sp.call(["mvn", "package"])
    print_hella_stars(5)
    print("running jar","."*38)
    print_hella_stars(1)
    sp.call(["java", "-jar", "target/gs-rest-service-0.1.0.jar"])
    print_hella_stars(1)
else:
    print("please run this script where pom.xml exists")
