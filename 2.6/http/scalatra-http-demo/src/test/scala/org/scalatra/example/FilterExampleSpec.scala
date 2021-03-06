package org.scalatra.example

import org.scalatra.test.specs2._

import org.scalatra._

class FilterExampleSpec extends ScalatraSpec { def is = s2"""
  GET /filter-example on FilterExample
    should return filtered body $filter
"""

  addFilter(classOf[FilterExample], "/*")
  addServlet(classOf[DummyServlet], "/*")

  def filter = get("/filter-example") {
    body must contain("This response was generated by the filter")
  }
}

class DummyServlet extends ScalatraServlet {
  get("/filter-example") {
    "dummy"
  }
}
