package com.lufax.jijin.daixiao.schedular.domain;


import com.lufax.jijin.base.utils.EmptyChecker;
import com.lufax.jijin.base.utils.Logger;
import com.lufax.jijin.base.utils.NumberUtils;
import com.lufax.jijin.daixiao.dto.JijinExIncomeModeDTO;
import com.lufax.jijin.fundation.dto.JijinSyncFileDTO;

import java.math.BigDecimal;

public class JijinExIncomeModeSyncReader {

    /*默认分红方式
    {信息提示}| {总笔数}|{数据起始时间}|{数据截止时间}
    序号|{字段1}|{字段2} |OPDATE
    1|xxxx|xxxx|2015-07-22 18:18:18
    1   基金代码
    2   默认分红方式
    3   最低持有份额
    */


    // 校验每条记录的完整性
    private boolean checkIntegrity(String[] args, JijinSyncFileDTO file, long num) {

        if (EmptyChecker.isEmpty(args[0]) || EmptyChecker.isEmpty(args[1])
                || EmptyChecker.isEmpty(args[2])
                || EmptyChecker.isEmpty(args[3])) {

            Logger.error(this, String.format(
                    "File is not in the correct format :[id: %s] [fileName : %s], line num  %s",
                    file.getId(), file.getFileName(), num));
            return false;
        }

        if (args.length != 6) {
            Logger.error(this, String.format(
                    "JijinExIncomeMode File length not correct :[id: %s] [fileName : %s], line num  %s",
                    file.getId(), file.getFileName(), num));
            return false;
        }

        return true;
    }


    public JijinExIncomeModeDTO readLine(String lineContent, long lineNum, JijinSyncFileDTO file) {

        try {
            if (lineNum > 2) {

                lineContent = lineContent + "|x"; // append '|x' to let parse correctly
                String[] args = lineContent.split("\\|");

                if (!checkIntegrity(args, file, lineNum)) return null;

                JijinExIncomeModeDTO dto = new JijinExIncomeModeDTO();
                dto.setFundCode(args[1]);
                dto.setIncomeMode(args[2]);
                dto.setMinHoldShareCount(NumberUtils.string2BigDecimal(args[3]));
                dto.setBatchId(file.getId());
                dto.setStatus("NEW");
                return dto;
            }
        } catch (Exception e) {
            return null;
        }
        return null;// line 1, just return null
    }


}
