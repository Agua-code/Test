package QZB;

import java.util.List;

/**
 * @program: PK
 * @description: 规则列表
 * @author: Mr.Sun
 * @create: 2018-09-26 19:00
 **/
public class Rule {
    /**
     *规则类型，包括"LTK_limit","Day_Crs_limit","Priority_class_limit","Weak_Crs_distributed","LTK_JP","FLTK_JP","JZSK"对应中文"连堂课限制","日课时限制","优先排课限制","周课时分布","连堂课教案平齐","非连堂课教案平齐","集中授课"
     */
    private String type;
    /**
     * 每一条规则的满足率
     */
    private String satisfctionRate;
    /**
     * 哪些课触发了该规则
     */
    private List<Unsatisfaction> unsatisfactions;
    /**
     * 触发了规则的具体节数
     */
    private List<ProblematicCrs> problematicCrsList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSatisfctionRate() {
        return satisfctionRate;
    }

    public void setSatisfctionRate(String satisfctionRate) {
        this.satisfctionRate = satisfctionRate;
    }

    public List<Unsatisfaction> getUnsatisfactions() {
        return unsatisfactions;
    }

    public void setUnsatisfactions(List<Unsatisfaction> unsatisfactions) {
        this.unsatisfactions = unsatisfactions;
    }

    public List<ProblematicCrs> getProblematicCrsList() {
        return problematicCrsList;
    }

    public void setProblematicCrsList(List<ProblematicCrs> problematicCrsList) {
        this.problematicCrsList = problematicCrsList;
    }
}
