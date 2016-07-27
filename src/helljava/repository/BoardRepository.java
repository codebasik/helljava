package helljava.repository;

import helljava.DB.MemoryDB;
import helljava.domain.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yongjunjung on 2016. 7. 25..
 */
public class BoardRepository {

    public void write(String username, String title, String content) {
        int maxSeq = this.findByMaxSeq();
        Board board = new Board(maxSeq+1,title,content ,username);
        MemoryDB.boardList.add(board);
    }

    public List<Board> findAll(String searchWord) {
        return MemoryDB.boardList.stream()
                .filter(b -> searchWord == null || b.getContent().contains(searchWord) || b.getUsername().contains(searchWord) || b.getTitle().contains(searchWord) || "".equals(searchWord))
                .collect(Collectors.toList());
    }

    public List<Board> findbyContent(String searchWord) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getContent().contains(searchWord))
                .collect(Collectors.toList());
    }

    public List<Board> findbyName(String searchWord) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getUsername().contains(searchWord))
                .collect(Collectors.toList());
    }

    public List<Board> findbyTitle(String searchWord) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getTitle().contains(searchWord))
                .collect(Collectors.toList());
    }

    public Board findbySeq(int seq) {
        return MemoryDB.boardList.stream()
                .filter(b -> b.getSeq() == seq)
                .findFirst()
                .orElse(null);
    }

    public int findByMaxSeq() {

        if(MemoryDB.boardList.size() == 0) {
            return 0;
        }

        return MemoryDB.boardList.stream()
                .max((s1, s2) -> Integer.compare(s1.getSeq(), s2.getSeq()))
                .get()
                .getSeq();
    }

    public void deleteBoard(int seq) {
        MemoryDB.boardList.removeIf(b -> b.getSeq() == seq);
    }

}
