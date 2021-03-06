package com.wh.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * @author WangHao
 * 2020-06-02
 */
@Component
public class MailHandler {

    @Autowired
    private JavaMailSender mailSender;

    public void send() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("来自Spring-boot的问候");
        mailMessage.setText("Hello, World");
        mailMessage.setFrom("wanghao519@sina.cn");
        mailMessage.setTo("wanghao@triumen.com");
        mailSender.send(mailMessage);
    }


    private static List list = new ArrayList<>();

    static {
        list.add("知道为什么自古红颜多薄命吗? 因为没有人在意丑的人活多久。");
        list.add("等忙完这一阵，就可以接着忙下一阵了。");
        list.add("长得丑就是病，不然整形医院为什么叫医院。");
        list.add("岁月是把杀猪刀，是针对那些好看的人，它对长得丑的人一点办法都没有。");
        list.add("人家说你看着小，其实并不是你娃娃脸，而是你穿得土。");
        list.add("别再抱怨你此生找不到一个对的人，当初的数学选择题就四个，你也找不到对的答案啊!");
        list.add("好人成佛需要九九八十一难可是坏人只需要放下屠刀。");
        list.add("如果你很忙，除了你这真的很重要之外，更可能的原因是：你很弱");
        list.add("我没见过一个煤矿工人靠挖煤又快又多当上了煤老板。");
        list.add("暴风雨之后，不仅没看到彩虹，还感冒了!");
        list.add("其实根本没有真正高冷的人,只不过人家暖的不是你。");
        list.add("幸亏当事者迷，不然真的看清事实真相，很多人是承受不来的。");
        list.add("多照照镜子，很多事情你就明白原因了。");
        list.add("假如今天生活欺骗了你，不要悲伤，不要哭泣，因为明天生活还会继续欺骗你。");
        list.add("你每天都那么努力，忍受了那么多的寂寞和痛苦。可我也没见你有多优秀。");
        list.add("喜欢一个人就勇敢表白，也许你还能知道自己是几号备胎。");
        list.add("有些人感慨：自己岁数不小了，还没有成熟起来。其实你们已经成熟起来了，你们成熟起来就这样。");
        list.add("明明可以靠脸吃饭，你却要靠才华，这就是你跟明明的差距");
        list.add("一场说走就走的旅行，回来等着你的就是一段吃土的日子");
        list.add("上帝给了你丑的外表跟低的智商，就是怕你不协调");
        list.add("失败并不可怕，可怕的是你还相信这句话");
        list.add("只要是石头，到哪里都不会发光。");
        list.add("有些人不是赢在了起跑线上，而是直接生在了终点。");
        list.add("有些人出现在你的生命里就是为了告诉你，你真好骗。");
        list.add("我不怕变成自己厌恶的人，我怕过得还不如他们。");
        list.add("人作的程度不能超过自己的颜值。");
        list.add("经过十年不断的努力和奋斗，我终于从一个懵懂无知的少年变成了一个懵懂无知的青年。");
        list.add("只要你每天坚持自习，认真刻苦，态度端正，忍受孤独，最终的胜利肯定是属于那些考场上发挥好的人。");
        list.add("对女人强吻表白一般会有两种结果，一种是啪，一种是啪啪啪。这就是屌丝和高富帅的差距。");
        list.add("如果有人问我：那些艰难的岁月你是怎么熬过来的?我想我只有一句话回答：我有一种强大的精神力量支撑着我，这种力量名字叫“想死又不敢”。");
        list.add("“长的好看的女人都不靠谱。”　“那不好看的呢?”“既不好看，又不靠谱。”");
        list.add("有些事不是努力就可以改变的，五十块的人民币设计的再好看，也没有一百块的招人喜欢。");
        list.add("所有抱怨社会不公和制度的人翻译过来只有一句话：请给我金钱，女人和社会地位。");
        list.add("失恋的时候，许多年轻人以为整个世界都抛弃了自己，别傻了，世界根本就没需要过你。");
        list.add("生活会让你苦上一阵子，等你适应以后，再让你苦上一辈子。");
        list.add("除了有钱人，世上还有两种人：其一是省吃俭用买奢侈品装逼的，其二是省吃俭用也买不起奢侈品的。");
        list.add("挣钱是一种能力，花钱是一种技术。你能力有限，技术却很高。");
        list.add("公主病的成因没别的，不是丑就是穷。“那有钱又漂亮脾气却不好的呢?”那本来就是公主，不叫病。");
        list.add("世上无难事只怕有钱人，物以类聚人以穷分。");
        list.add("女生的冷暖自知什么的，在长的好看的面前都弱爆了。");
        list.add("努力了这么久，但凡有点儿天赋，也该有些成功的迹象了。");
        list.add("你总嫌有些人懒，说得好像你勤快了就真能干出什么大事儿一样。");
        list.add("所谓的女汉子，只不过是因为长得丑而已，但凡有些爷们气质的漂亮姑娘，都被称为女王大人。");
        list.add("年轻人嘛，现在没钱算什么，以后没钱的日子还多着呢。");
        list.add("你这张脸只要遮住两个地方就完美了!一处是右半边脸，另一处是左半边脸。");
        list.add("你以为只要长得漂亮就有男生喜欢?你以为只要有了钱漂亮妹子就自己贴上来了?你以为学霸就能找到好工作?我告诉你吧，这些都是真的!");
        list.add("减肥就是要向妈妈证明，不光胖找不到对象，瘦也找不到!");
        list.add("每做一件事我都要三思而后行：能不能一会做?能不能明天做?能不能不要做?");
        list.add("父母的期望面前我们不敢说不行，我们总是用行动告诉他们我不行。");
        list.add("有些事可以放到明天做，不然明天没得事做会更惨");
        list.add("如果我的离开能够换来你的幸福，那我就不离开看你怎么就不幸福了!!");
        list.add("爱笑的女孩，鱼尾纹都比较多");
        list.add("别说自己一无所有，这不还有病吗?");
        list.add("当别人不懂你的时候不要难过，因为他或许不是真不懂，而是不想懂");
        list.add("学习了很多如何成为有钱人的方法，钱存在银行里会贬值，要理财炒股才能致富，走了一圈却发现自己穷得都没钱入门。");
        list.add("感谢那些曾经把我击倒的人，谢谢你们，躺着真舒服");
        list.add("关键时刻掉链子估计我掉的链子可以绕地球三圈了吧");
        list.add("谁还没点拿手的乐器?我退堂鼓就打得一级棒");
        list.add("你并不是一无所有，还有贫穷与脂肪");
        list.add("给你多大的舞台 你就能丢多大的脸");
        list.add("这么晚还睡不着的人就别睡了，反正明天你也起不来");
        list.add("人生真是充满欢笑和泪水。部分人主要负责欢笑，另一部分人主要负责泪水。");
        list.add("加油，你是最胖的!");
        list.add("比三观更重要的是五官");
        list.add("不和喜欢的人接触一下，你都不知道他渣到爆炸");
        list.add("真正努力过得人才知道，天赋有多重要");
        list.add("上帝给了你一张丑的脸一定还会给你一个没钱的家");
        list.add("当你觉得自己又丑又穷一无是处时，别绝望，因为至少你的判断还是对的");
        list.add("三分天注定 七分靠打拼剩下的九十分你永远也拿不到");
        list.add("虽然我个子低，但我发际线高啊!");
        list.add("年轻人着急买什么房啊，找得着对象吗长那么丑?");
        list.add("上帝为你关上了门，顺便把窗户也关了，还顺手帮你打开了煤气开关");
        list.add("拼了命的努力 就是为了证明自己不行");
        list.add("梦想还是要有的，万一别人实现了呢");
        list.add("交给我你就不用放心了，没有错不了的事儿");
        list.add("只要坚持下去，总会有失败的一天。");
        list.add("你必须敢爱敢恨，才会发现你的爱恨别人真的不在乎");
        list.add("生活不仅能击败你，还会直接把你打倒!");
        list.add("一直想当一个妖艳的贱货，到最后照了照镜子，发现自己仅仅只是一个贱货。");
        list.add("在不疯狂就老了，疯狂过后发现老的更快.....");
        list.add("当你学会破罐破摔 你会发现这世界豁然开朗");
        list.add("努力减肥吧 然后你会发现 你丑不是因为你胖");
        list.add("一觉醒来，是不是感觉离梦想又远了呢。");
        list.add("做完全的准备，就是为了机遇来临时，巧妙的的躲过它。");
        list.add("世上无难事 只要肯放弃");
        list.add("只要我肯努力 就没有搞不砸的事情。");
        list.add("丑小鸭变成白天鹅，并不是它有多努力，而是它父母就是白天鹅");
        list.add("喜欢的人一定要去告白呀。不被拒绝一下你还真当自己是仙女了。");
        list.add("虽然我长得丑 但是买了漂亮衣服,我就可以丑的漂亮");
        list.add("好好活下去 每天都有新打击");
        list.add("充钱也抽不到ssr");
        list.add("善良没用，你得漂亮");
        list.add("人生就是一个起落落落落落...的过程");
        list.add("有些事情做不完，就留到明天做吧。运气好的话，明天死了就不用做了。");
        list.add("活着的时候把自己搞得好看一点，这样你就不会死得太难看");
    }

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 结合模板使用
     */
    @Async // 异步请求
    public void sendByTemplate() throws MessagingException {
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
        helper.setSubject("good good study, day day up");
        // 渲染页面
        Context context = new Context();
        Map<String, Object> map = new HashMap<>();
        int index = new Random().nextInt(list.size());
        map.put("title", "营养乌鸡汤");

        System.out.println(list.get(index));
        map.put("content", list.get(index));

        context.setVariables(map);
        String result = this.templateEngine.process("mailTest", context);

        // 设置文本，且html标志位true
        helper.setText(result, true);

        helper.setFrom("wanghao519@sina.cn");
        helper.setTo("1462455761@qq.com");

        // 添加附件
//        String filePath = "C:\\Users\\Administrator\\Desktop\\Redis学习笔记.md";
//        FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
//        helper.addAttachment("走你.md", fileSystemResource);

        mailSender.send(mailMessage);
        System.out.println("发送完了");
    }

    /**
     * @Scheduled() 配置定时执行的注解, 支持cron表达式
     * 赵胖胖同学不喜欢，所以就给关了吧
     */

/*    @Scheduled(cron = "0 0/30 * * * ?")
    public void comfort() throws MessagingException {
        sendByTemplate();
    }*/

}
