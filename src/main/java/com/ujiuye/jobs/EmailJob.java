package com.ujiuye.jobs;

import com.ujiuye.info.bean.Email;
import org.quartz.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public class EmailJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        Email email = (Email) dataMap.get("email");
        Scheduler scheduler = (Scheduler) dataMap.get("scheduler");
        JavaMailSenderImpl javaMailSenderImpl = (JavaMailSenderImpl) dataMap.get("javaMailSenderImpl");

        try{
            MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom("1170959718@qq.com");
            helper.setTo(email.getEname());
            helper.setSubject(email.getTitle());
            helper.setText(email.getContent(),true);
            // 发送邮件
            javaMailSenderImpl.send(mimeMessage);
            System.out.println("带附件的简单邮件发送OK");
            scheduler.shutdown(true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
