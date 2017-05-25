package test

import grails.util.Holders
import grails.validation.Validateable

/**
 * Created by mx1 on 25/05/17.
 */
class TestingBean implements Validateable{

    String name


    String getEncodedName() {
        return name.encodeAsRaw()
    }

    String message

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
    private def pretifyContent(String content) {
        return Holders.grailsApplication.mainContext.groovyPageRenderer.render(template: '/test/template',
                model: [content:content])
    }
 }
