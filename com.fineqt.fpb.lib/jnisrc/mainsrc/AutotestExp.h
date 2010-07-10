/****************************************************************
Fine Packet Builder, copyright (C) 2007-2009 fineqt.com

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
GNU General Public License for more details at gnu.org.
******************************************************************/
#ifndef AUTOTESTEXP_H_
#define AUTOTESTEXP_H_
#include <exception>
class AutotestExp : public std::exception {
public:
    AutotestExp(const char * msg = "") : msg_(msg) {
    }
    virtual const char * what() const throw() {
        return msg_.c_str();
    }
    virtual ~AutotestExp() throw(){};
private:
    std::string msg_;
};
class ResourceLoadException : public AutotestExp {
public:
    ResourceLoadException(const char * msg = "") : AutotestExp(msg){}
    virtual ~ResourceLoadException() throw(){};
};
class InvalidCastException : public AutotestExp {
public:
    InvalidCastException(const char * msg = "") : AutotestExp(msg){}
    virtual ~InvalidCastException() throw(){};
};
class ReplaceFailure : public AutotestExp {
public:
    ReplaceFailure(const char * msg = "") : AutotestExp(msg){}
    virtual ~ReplaceFailure() throw(){};
};
//Protocolを解析する異常定義
class PktDecodeException : public AutotestExp {
public:
    PktDecodeException(const char * msg = "") : AutotestExp(msg){}
    virtual ~PktDecodeException() throw(){};
};
class ScriptException : public AutotestExp {
public:
    ScriptException(const char * msg = "") : AutotestExp(msg){}
    virtual ~ScriptException() throw(){};
};
//Pduを建てる異常定義
class PktEncodeException : public AutotestExp {
public:
    PktEncodeException(const char * msg = "") : AutotestExp(msg){}
    virtual ~PktEncodeException() throw(){};
};
//Pdu関連処理異常
class PduProcessException: public AutotestExp {
public:
    PduProcessException(const char * msg = "") : AutotestExp(msg){}
    virtual ~PduProcessException() throw(){};
};
#endif /*AUTOTESTEXP_H_*/
