package com.kei

class Blog {

    String title
    String content
    Date   dateCreated
    Date   dateUpdated

    static hasMany     = [comments:Comment]
    static constraints = {
         
    }
}
