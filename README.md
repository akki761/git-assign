Q1)  Look up java plugin documentation. Make changes in manifest to make it executable with correct class. When run using java -jar JAR_NAME_HERE the output should be text "Hello World" on the console. 
    
      add apply plugin: 'java' and create hello class and make jar using 
      jar{                                        
    manifest{
        attributes 'Main-Class':'hello'
    }
}

sync and build. a jar file will be created. 


Q2)look up idea plugin. make changes in build.gradle so that the sources of src/main/java as well as src/main/java2 are taken as sources. Ensure that when you make JAR file class files in both are added to the JAR. This will teach you how projects with non-conventional structure can be used with gradle.

    apply plugin: 'idea' 
    add source sets as follows
    sourceSets{                                  
     main{
        java{

            srcDirs = ['src/main/java','src/main/java2']
        }
    }
}

build and run file

Q3)  add 2 files file1.xml and file1.txt in src/main/resources manually. make changes so that when creating jar only file1.xml is added to the jar. 

after adding file write following in build.gradle
sourceSets{                                
    main{
        resources{
            exclude 'file.txt'
        }
    }
} 

Q4) find how to what is an uberjar. Make changes so you can use commons lang3 StringUtil in your jar. Make this uber jar executable. The output should be text but that should be using the StringUtils class of commons lang3

add dependency compile 'org.apache.commons:commons-lang3:3.6'

add task uberjar as below

task uberjar(type: Jar, dependsOn: [':compileJava', ':processResources']) {
    from files(sourceSets.main.output.classesDir)
    from configurations.runtime.asFileTree.files.collect { zipTree(it) }

    manifest {
        attributes 'Main-Class': 'hello'
    }
} 
 now build and run code
 
 Q5)  Find a maven repository and add it as a repository in your build.gradle. You can use bintray, jcenter or any other repository. The goal is to learn how to use a custom repository
 
 add  maven{

        url "http://maven.petrikainulainen.net/repo"
    } 
    in repository in build.gradle
    
Q6) Write a task in file "mytasks.gradle" and use it in your build.gradle. The goal is to be able to use tasks from another file in your build.gradle

create mytasks.gradle and write task as:
task(hello){
  println "hellomytask"
}

now write apply from: 'mytasks.gradle' in build.gradle

now build and run gradle code
