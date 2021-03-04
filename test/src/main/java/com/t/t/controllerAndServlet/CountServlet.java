package com.t.t.controllerAndServlet;

import com.t.t.models.Board;
import com.t.t.models.BoardSquare;
import com.t.t.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.t.t.specs.PositionConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/count")
public class CountServlet extends HttpServlet {

    @Autowired
    private CountService countService;

    @Autowired
    private PositionConverter positionConverter;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int width = Integer.parseInt(req.getParameter("width"));
        int height = Integer.parseInt(req.getParameter("height"));
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        Board board = new Board(width, height);
        BoardSquare startPos = positionConverter.convertStringToBoardSquare(start);
        BoardSquare endPos = positionConverter.convertStringToBoardSquare(end);
        if (startPos.getX() > board.getWidth() || startPos.getY() > board.getHeight() || endPos.getX() > board.getWidth() || endPos.getY() > board.getHeight()) {
            resp.sendError(400);
        }
        int result = countService.countDistance(startPos, endPos, board);
        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(result);
        printWriter.flush();
        printWriter.close();
    }
}
