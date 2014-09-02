appengine-multi-module-skeleton
===============================

Skeleton for a multi module appengine application. 

The main modules are: 
- **frontend** - the common webapp for the orginary users, scales unlimited
- **admin** - webapp for adminstration purposes, only accessable for configured accounts, scales not
- **shared** - contains shared code used in both webapp 

How to use
==========

clone this repository using 

	git clone git@github.com:mpoehler/appengine-multi-module-skeleton.git

and install the archetype into your local repository using

	cd appengine-multi-module-skeleton
	mvn install

then create a new project based on the archetype

	mvn archetype:generate \
	-B \
	-DarchetypeArtifactId=appengine-multi-module-skeleton-archetype \
	-DarchetypeGroupId=eu.tuxoo \
	-DarchetypeVersion=1.0 \
	-DgroupId=com.mypackage \
	-DartifactId=gaemultimodule \
	-Dversion=1.0 \
	-Dpackage=com.mypackage \
	-Dgoals=install

This will generate a new project in a directory *gaemultimodule* and build it after creation.

The project can be started immediatelly on the devserver:

	cd gaemultimodule/ear
	mvn appengine:devserver

Now the frontend is accessable on [http://localhost:8080](http://localhost:8080)

and the admin is accessable on [http://localhost:8081](http://localhost:8081)

