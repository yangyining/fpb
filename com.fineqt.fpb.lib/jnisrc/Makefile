#root初期ファイルのインクルード
-include ../init.mk
all: init
	$(MAKE) -C mainsrc -I $(COMMON_FOLD) all
	$(MAKE) -C testsrc -I $(COMMON_FOLD) all
#	cp ../lib/libfpb.so ../libfpb.so
	
init:

#copy.lib:
#	rm -f ../lib/*.so
#	cp -f lib/*.so ../lib
	
clean:
	$(MAKE) -C testsrc -I $(COMMON_FOLD) clean
	$(MAKE) -C mainsrc -I $(COMMON_FOLD) clean
	
main:
	$(MAKE) -C mainsrc -I $(COMMON_FOLD) all
#	cp ../lib/libfpb.so ../libfpb.so

clean.main:
	$(MAKE) -C mainsrc -I $(COMMON_FOLD) clean

