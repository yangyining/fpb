OUTPUT_PROG_FOLD=..

PROG=suiteapp

PROG_DPDS=$(OUTPUT_PROG_FOLD)/lib$(FPB_LIB).so

#source path
FILE=autotesttest \
	pcaptest

#system path
INCLUDE_PATH+=-I../mainsrc
			
LIB_PATH+= -L$(OUTPUT_PROG_FOLD)/

#libs
LIB_NAME=-l$(FPB_LIB) 

-include common_prg.mk

#complier options
#CCFLAGS += -DACE_NTRACE=1
#CCFLAGS += -DACE_NDEBUG=1
#CCFLAGS += -DACE_NLOGGING=1
