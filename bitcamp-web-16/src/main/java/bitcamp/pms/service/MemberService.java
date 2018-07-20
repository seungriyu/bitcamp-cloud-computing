package bitcamp.pms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Service
public class MemberService {
    //의존 객체 주입
    @Autowired MemberDao memberDao;
    
    public List<Member> list(int page, int size) {
        // DB에서 가져올 데이터의 페이지 정보
        HashMap<String, Object> params = new HashMap<>();
        params.put("startIndex", (page - 1) * size);
        params.put("pageSize", size);
        // 시작인덱스 = page -1 * 3

        return memberDao.selectList(params);
    }

    public Member get(String id) {
        // TODO Auto-generated method stub
        return memberDao.selectOne(id);
    }

    public int update(Member member) {
        return memberDao.update(member);
    }

    public int delete(String id) {
        return memberDao.delete(id);
        
    }

    public void add(Member member) {
       memberDao.insert(member);
       
    }
    
    public int getTotalPage(int size) {
        int count = memberDao.countAll();
        int totalPage = count/size;
        if(count % size > 0) {
            totalPage++;
        }
        return totalPage;
    }
}
