build:
	@javac -d ./out -sourcepath ./ -Xlint:unchecked forms/main.java

run:
	@java -cp ./out forms.main
