package helljava.repository;

import helljava.DB.MemoryDB;
import helljava.domain.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by yongjunjung on 2016. 7. 26..
 */
public class BoardRepositoryTest {

    BoardRepository boardRepository = new BoardRepository();

    @Before
    public void initialize() {
        Board board = new Board(1, "111", "111", "111");
        Board board1 = new Board(2, "111", "222", "222");
        Board board2 = new Board(3, "222", "111", "111");
        Board board3 = new Board(4, "444", "333", "111");

        MemoryDB.boardList.add(board);
        MemoryDB.boardList.add(board1);
        MemoryDB.boardList.add(board2);
        MemoryDB.boardList.add(board3);

    }

    @Test
    public void findAll() {
        List<Board> all = boardRepository.findAll(null);
        assertEquals(4, all.size());
    }

    @Test
    public void findbyContent() {
        List<Board> all = boardRepository.findbyContent("333");
        assertEquals("444", all.get(0).getTitle());
    }

    @Test
    public void findbyName() {
        List<Board> all = boardRepository.findbyName("333");
        assertEquals(0, all.size());

    }

    @Test
    public void findByMaxSeq() {
        int seq = boardRepository.findByMaxSeq();
        assertEquals(4, seq);
    }

    @Test
    public void 아무것도없을때() {

        MemoryDB.boardList.remove(3);
        MemoryDB.boardList.remove(2);
        MemoryDB.boardList.remove(1);
//        MemoryDB.boardList.remove(0);

        int seq = boardRepository.findByMaxSeq();
        assertEquals(1, seq);
    }






}