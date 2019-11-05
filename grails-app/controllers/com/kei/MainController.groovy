package com.kei

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MainController {

    MainService mainService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mainService.list(params), model:[mainCount: mainService.count()]
    }

    def show(Long id) {
        respond mainService.get(id)
    }

    def create() {
        respond new Main(params)
    }

    def save(Main main) {
        if (main == null) {
            notFound()
            return
        }

        try {
            mainService.save(main)
        } catch (ValidationException e) {
            respond main.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'main.label', default: 'Main'), main.id])
                redirect main
            }
            '*' { respond main, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mainService.get(id)
    }

    def update(Main main) {
        if (main == null) {
            notFound()
            return
        }

        try {
            mainService.save(main)
        } catch (ValidationException e) {
            respond main.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'main.label', default: 'Main'), main.id])
                redirect main
            }
            '*'{ respond main, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mainService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'main.label', default: 'Main'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'main.label', default: 'Main'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
