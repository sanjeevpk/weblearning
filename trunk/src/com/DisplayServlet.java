package com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Image;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String imagePath;
	 Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	 
	 public void init() throws ServletException {

	        // Define base path somehow. You can define it as init-param of the servlet.
	        this.imagePath = "/images";

	        // In a Windows environment with the Applicationserver running on the
	        // c: volume, the above path is exactly the same as "c:\images".
	        // In UNIX, it is just straightforward "/images".
	        // If you have stored files in the WebContent of a WAR, for example in the
	        // "/WEB-INF/images" folder, then you can retrieve the absolute path by:
	        // this.imagePath = getServletContext().getRealPath("/WEB-INF/images");
	    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imageId = request.getParameter("id");
		System.out.println(imageId);
		InputStream sImage;

        // Check if ID is supplied to the request.
        if (imageId == null) {
            // Do your thing if the ID is not supplied to the request.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        try{
	       	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_learning", "root","root");
			stmt = conn.prepareStatement("select * from contacts where contact_id=" + imageId);
			rs = stmt.executeQuery();
			Image image =  new Image();
			if(rs.next()){
				System.out.println("Inside RS");
				byte[] bytearray = new byte[1048576];
				int size=0;
				sImage = rs.getBinaryStream(4);
				response.reset();
				response.setContentType("image/jpeg");
				while((size = sImage.read(bytearray))!= -1 ){
					response.getOutputStream().
					write(bytearray,0,size);
					}
					}

					} catch (Exception e){
					e.printStackTrace();
					}
					}
				
				/*image.setId(rs.getString(1));
				image.setContent(rs.getBytes(2));
			}    	

        // Init servlet response.
        response.reset();
        response.setBufferSize(10240);
        //response.setContentType(image.getContentType());
        response.setContentLength(image.getContent().length);
        response.setHeader("Content-Disposition", "inline; filename=\"" + "Photo" + "\"");

        // Prepare streams.
        BufferedOutputStream output = null;
       

        try {
            // Open streams.
            output = new BufferedOutputStream(response.getOutputStream(), 10240);

            // Write file contents to response.
            System.out.println("Displaying Image");
            output.write(image.getContent());
        } finally {
            // Gently close streams.
            close(output);
        }
        }catch(Exception e){
        	System.out.println(e);
        }*/
	    //}

	    // Helpers (can be refactored to public utility class) ----------------------------------------

	    private static void close(Closeable resource) {
	        if (resource != null) {
	            try {
	                resource.close();
	            } catch (IOException e) {
	                // Do your thing with the exception. Print it, log it or mail it.
	                e.printStackTrace();
	            }
	        }
	    }


}
