package com.kei

class Comment {

    String comment
    Date   dateCreated
    Date   dateUpdated

    static belongsTo   = [blog: Blog]
    static constraints = {
        comment(blank: false, nullable: false, size: 5..500)
    }

    String toString() {
        if (comment?.size() > 20) {
            return comment.substring(0, 20)
        } 
        return comment
    }
}
