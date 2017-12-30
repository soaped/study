package com.xyls.common.common_mq;

import java.io.Serializable;

;

public interface PriorityMessage extends Serializable{

    int getPriority();
}
