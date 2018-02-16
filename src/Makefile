.PHONY: particles
particles:
	cd utils; \
	javac -g -classpath . *.java; \
	cd ../simulation; \
	javac -g -classpath .:.. *.java; \

.PHONY: clean
clean:
	rm simulation/*.class utils/*.class
