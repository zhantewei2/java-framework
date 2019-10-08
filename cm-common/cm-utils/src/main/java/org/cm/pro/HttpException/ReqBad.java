package org.cm.pro.HttpException;

import org.springframework.http.HttpStatus;

public class ReqBad extends BaseException {
    public ReqBad(Object a){
        super(a);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
