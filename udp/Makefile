include ../make.include
DPDK=/usr/local/dpdk/dpdk_src
DPDK_FLAGS=$(shell cat ${DPDK}/include/cflags.txt)
DPDK_LIB_FLAGS = $(shell cat ${DPDK}/lib/ldflags.txt)
CFLAGS  = ${BUILD_CFLAGS}  -O0 -rdynamic -D_GNU_SOURCE -DUSE_DPDK ${DPDK_FLAGS} -pthread
CFLAGS += -I../lib/common  -I../lib/shm -I../lib/thread -I../lib/ptables  -I../packet -I../MProcess -I./dns/ -I. -I${DPDK}/include -include ${DPDK}/include/rte_config.h

LDFLAGS  = ${BUILD_LDFLAGS} ${DPDK_LIB_FLAGS}


common_package = ../lib/common/*.o
cpool_package = ../lib/thread/*.o
shm_package = ../lib/shm/*.o
ptables_package = ../lib/ptables/*.o
pkt_package = ../packet/*.o
mprocess_package = ../MProcess/*.o
dns_package = ./dns/*.o


udp_package= UDPMain

udp_SOURCES = UDPMain.c \
			 ch_udp_context.c \
			 ch_udp_app_pool.c \
			 ch_udp_session.c \
			 ch_udp_session_handler.c \
			 ch_udp_session_pool.c \
			 ch_udp_session_task.c \
			 ch_udp_session_task_pool.c \
			 ch_udp_work.c

udp_OBJECTS =$(patsubst %.c,%.o,$(udp_SOURCES))
udp_DEPENDS =$(patsubst %.c,%.d,$(udp_SOURCES))
udp_ASMFILE =$(patsubst %.c,%.s,$(udp_SOURCES))

quiet_cmd_dpdk = LINK   $@ 
	cmd_udp = ${CC} ${CFLAGS} -o $@ $(udp_OBJECTS)  \
				   $(common_package) $(cpool_package) $(shm_package) $(ptables_package)\
				   $(pkt_package)  $(mprocess_package) $(dns_package)\
				   $(LDFLAGS)

.PHONY: all clean

all: $(udp_package)

$(udp_package): $(udp_OBJECTS) 
	$(call cmd,udp)
-include $(udp_DEPENDS)

$(common_package):
	$(call,make)

$(shm_package):
	$(call,make)

$(thread_package):
	$(call,make)

$(ptables_package):
	$(call,make)

$(pkt_package):
	$(call,make)

$(mprocess_package):
	$(call,make)

$(dns_package):
	$(call,make)

clean:
	@rm -rf $(udp_OBJECTS) $(udp_DEPENDS) $(udp_ASMFILE) $(udp_package)


