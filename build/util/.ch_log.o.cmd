cmd_ch_log.o = gcc -Wp,-MD,./.ch_log.o.d.tmp  -m64 -pthread  -march=native -DRTE_MACHINE_CPUFLAG_SSE -DRTE_MACHINE_CPUFLAG_SSE2 -DRTE_MACHINE_CPUFLAG_SSE3 -DRTE_MACHINE_CPUFLAG_SSSE3 -DRTE_MACHINE_CPUFLAG_SSE4_1 -DRTE_MACHINE_CPUFLAG_SSE4_2 -DRTE_MACHINE_CPUFLAG_AES -DRTE_MACHINE_CPUFLAG_PCLMULQDQ -DRTE_MACHINE_CPUFLAG_AVX -DRTE_MACHINE_CPUFLAG_RDRAND -DRTE_MACHINE_CPUFLAG_FSGSBASE -DRTE_MACHINE_CPUFLAG_F16C -DRTE_MACHINE_CPUFLAG_AVX2  -I/home/shajf/dev/antell/CloudHand/build/util/build/include -I/home/shajf/dev/antell/CloudHand/build/tar/dpdk-17.02/x86_64-native-linuxapp-gcc/include -include /home/shajf/dev/antell/CloudHand/build/tar/dpdk-17.02/x86_64-native-linuxapp-gcc/include/rte_config.h -O3 -g  -I/home/shajf/dev/antell/CloudHand/build/util `/usr/local/apr/bin/apr-1-config --includes` `/usr/local/apr/bin/apu-1-config --includes`    -o ch_log.o -c ch_log.c 
