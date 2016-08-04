package helljava.service;

import helljava.domain.Board;
import helljava.repository.BoardRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yongjunjung on 2016. 7. 26..
 */
public class BoardService {

    BoardRepository boardRepository = new BoardRepository();

    public List<Board> boardList(HttpServletRequest request) {
        return boardRepository.list(request);
    }

    public void addBoard(HttpServletRequest request) {
        boardRepository.write(request);
    }

    public Board getBoardDetail(int seq) {
        return boardRepository.findbySeq(seq);
    }

    public void delete(int seq) {
        boardRepository.deleteBoard(seq);
    }
}
