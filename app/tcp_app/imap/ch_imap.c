/************************************************************************
 *
 *      Filename: app/imap/a.h
 *
 *        Author: g.goodian@gmail.com
 *   Description: ---
 *        Create: 2016-06-23 03:35:33
 * Last Modified: 2016-12-05 19:47:26
 *************************************************************************/
#include "ch_imap.h"
#include "ch_app_util.h"
#include "ch_mmap_file_format.h"
#include "ch_tcp_data_writer.h"
#include "ch_app_context_tcp.h"

static int imap_recognize_by_port(ch_app_t *app, uint16_t src_port, 
			uint16_t dst_port, void *priv_data)
{
    
	ch_app_context_tcp_t *tcontext = (ch_app_context_tcp_t*)app->app_context;

    return ch_ports_equal(tcontext->imap_ports,PORT_MAX_SIZE,src_port,dst_port);
}

static int imap_recognize_by_content(ch_app_t *app, void *data,size_t dlen, void *priv_data)
{
    
    return 1;
}


static int imap_content_process(ch_app_t *app,void *data, size_t dlen, void *priv_data)
{
    return ch_tcp_data_write(priv_data,data,dlen,PACKET_TYPE_DATA,PROTOCOL_IMAP);
}

static void imap_content_flush(ch_app_t *app,void *priv_data)
{
    ch_tcp_data_write(priv_data,NULL,0,PACKET_TYPE_FLUSH,PROTOCOL_IMAP);
}

static void imap_content_close(ch_app_t *app,void *priv_data)
{
    ch_tcp_data_write(priv_data,NULL,0,PACKET_TYPE_CLOSE,PROTOCOL_IMAP);
}

static ch_app_t imap_app = {
    .app_recognize_by_port = imap_recognize_by_port,
    .app_recognize_by_content = imap_recognize_by_content,
    .app_content_process = imap_content_process,
    .app_content_flush = imap_content_flush,
    .app_content_close = imap_content_close,
};

int ch_imap_init(ch_app_context_t *app_context)
{
    ch_app_context_register(app_context, &imap_app);
    return 0;
}

