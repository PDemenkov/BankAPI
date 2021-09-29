package com.example.bankapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NoSuchUserException.class)
    protected ResponseEntity<MyException> handlerNoSuchUserException() {
        return new ResponseEntity<MyException>(new MyException("Пользователь не найден"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchCounterPartyException.class)
    protected ResponseEntity<MyException> handlerNoSuchCounterPartyException() {
        return new ResponseEntity<MyException>(new MyException("Контрагент не найден"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchAccountException.class)
    protected ResponseEntity<MyException> handlerNoAccountException() {
        return new ResponseEntity<MyException>(new MyException("Счет не найден"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchCardException.class)
    protected ResponseEntity<MyException> handlerNoSuchCardException() {
        return new ResponseEntity<MyException>(new MyException("Карта не найдена"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    protected ResponseEntity<MyException> handlerNotEnoughMoneyException() {
        return new ResponseEntity<MyException>(new MyException("Недостаточно средств"), HttpStatus.NOT_FOUND);
    }


    private static class MyException {
        private String msg;

        public MyException(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
