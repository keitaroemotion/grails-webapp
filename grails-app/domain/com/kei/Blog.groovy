package com.kei

class Blog {

    String title
    String content
    Date   dateCreated
    Date   dateUpdated

    static hasMany     = [comments: Comment]
    static constraints = {
        title  (blank: false, nullable: false, size: 3..80)
        content(blank: false, nullable: false, size: 3..500)
    }
}
