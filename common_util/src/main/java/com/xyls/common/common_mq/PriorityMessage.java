package com.yangfuzhao.common.common_mq;

import java.io.Serializable;

;

public interface PriorityMessage extends Serializable{

    int getPriority();
}
