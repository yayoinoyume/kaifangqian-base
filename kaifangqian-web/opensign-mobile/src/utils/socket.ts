/**
 * @description : WebSocketService.ts
 */
// WebSocketService.ts

import { ref, onBeforeUnmount } from 'vue';

export interface WebSocketServiceOptions {
    url: string;
}

export class WebSocketService {
    private socket: WebSocket | null = null;
    private messageCallback: ((data: any) => void) | null = null;

    public isConnected = ref(false);

    constructor(options: WebSocketServiceOptions) {
        this.connect(options.url);
    }

    private connect(url: string): void {
        var wsUrl = url.replace("https://", "wss://").replace("http://", "ws://");
        console.log('wsUrl地址', wsUrl)
        this.socket = new WebSocket(wsUrl);

        this.socket.addEventListener('open', () => {
            this.isConnected.value = true;
            console.log('QR socket链接已建立')
        });

        this.socket.addEventListener('message', (event) => {
            console.log(event, '有消息')
            if (this.messageCallback) {
                this.messageCallback(JSON.parse(event.data));
            }
        });

        this.socket.addEventListener('close', () => {
            this.isConnected.value = false;
            console.log('QR socket链接已关闭')
        });
    }

    public setMessageCallback(callback: (data: any) => void): void {
        this.messageCallback = callback;
    }

    public close(): void {
        if (this.socket) {
            this.socket.close();
            this.socket = null;
        }
    }
}

export function useWebSocketService(options: WebSocketServiceOptions): WebSocketService {
    const service = new WebSocketService(options);

    // Automatically close the WebSocket when the component is unmounted
    onBeforeUnmount(() => {
        service.close();
    });

    return service;
}
