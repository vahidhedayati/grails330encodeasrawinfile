# grails328plusencoderaw

original example had issues and had to be recreated. The issue appears to be something else related to possibly file i/o and encodeAsRaw.



This is identical behaviour in grails 3.2.8 and 3.3.0 had been working fine under grails 2 and using grails 3.1.10

You will need to navigate to index4:


```
Result is <a href="/something">Some link</a> vs Some link 
Message is:
----------------<br/><p><a href="/something">Some link</a></p> 
```


Message is expected to be actual link the content is the same as `getEncodedName()`

```groovy

def formatBean() {
        try {
            def file = new File("/tmp/content")
            String prettyContent = pretifyContent(name.encodeAsRaw())
            byte[] bytesArray = prettyContent.getBytes()
            def fos = new FileOutputStream(file)
            fos.write(bytesArray)
            fos.flush()


            FileInputStream inputStream = new FileInputStream(file)
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
            StringBuilder out = new StringBuilder()
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line)
            }
            message =out.toString()
            reader.close()


        }catch (Exception e) {
            println "_ $e"
        }

    }
```

Message being the output of the file produces raw link - as mentioned this was working in 3.1.10 


# grails330encodeasrawinfile
