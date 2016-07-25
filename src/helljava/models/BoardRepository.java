package helljava.models;

import helljava.domain.Board;

/**
 * Created by yongjunjung on 2016. 7. 25..
 */
public class BoardRepository {

    public void write(String username, String title, String content) {

        Board board = new Board(title,content ,username);
        Board.boardList.add(board);
    }

}
