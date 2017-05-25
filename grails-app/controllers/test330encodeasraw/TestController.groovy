package test330encodeasraw

import test.TestingBean

class TestController {

    def index() {

        def result = """<a href="/something">Some link</a>"""

        render view:'index', model:[result:result, encoded:result.encodeAsRaw()]
    }

    def index2() {

        def result = """<a href="/something">Some link</a>"""

        render view:'index2', model:[result:result, encoded:result.encodeAsRaw()]
    }

    def index3() {

        def result = """<a href="/something">Some link</a>"""

        render view:'index3', model:[result:result, encoded:result.encodeAsRaw()]
    }

    def index4(TestingBean bean) {

        bean.name="""<a href="/something">Some link</a>"""
        bean.formatBean()
        render view:'index4', model:[instance:bean]
    }



}
