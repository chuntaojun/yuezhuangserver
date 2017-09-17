package com.yueserver.service.feedback;

import com.yueserver.enity.nodao.IssueForMct;
import com.yueserver.enity.nodao.IssueForUser;
import com.yueserver.service.EmailInterface;
import com.yueserver.service.SolveIssueInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("SolveIssueService")
public class SolveIssueService implements SolveIssueInterface {

    @Autowired
    @Resource(name = "Emailservice")
    private EmailInterface emailInterface;

    @Override
    public boolean SolveIssueForMct(IssueForMct issueForMct) {
        return emailInterface.SendIssueFeedBack(issueForMct.getMctemail(), FeedIssueForMct(issueForMct));
    }

    @Override
    public boolean SolveIssueForUser(IssueForUser issueForUser) {
        return false;
    }

    private String FeedIssueForMct(IssueForMct issueForMct) {
        String feed = "尊敬的" + issueForMct.getMctname() + "\n" +
                "   您与" + issueForMct.getQuestime().toString() +
                "提出的问题我们已作出反馈，如下：" + "\n" +
                issueForMct.getSolve() + "\n" +
                new Date().toString();
        return feed;
    }

    private String FeedIssueForUsr(IssueForUser issueForUser) {
        return null;
    }
}
