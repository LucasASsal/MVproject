import java.io.IOException;
import java.net.InetSocketAddress;
import com.api.services.ProductService;
import com.sun.net.httpserver.HttpServer;


class ApplicationMain {

	public static void main(String[] args){
        int serverPort = 8000;
        HttpServer server = null;
		try {
			server = HttpServer.create(new InetSocketAddress(serverPort), 0);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        ProductService productService = new ProductService();
        server.createContext("/api/produto", productService::handle);
        System.out.println("Server running...at port: "+serverPort );
        server.setExecutor(null); 
        server.start();
    }
}

