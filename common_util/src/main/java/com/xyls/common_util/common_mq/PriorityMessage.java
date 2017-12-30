package com.xyls.common_util.common_mq;

import java.io.Serializable;

;

public interface PriorityMessage extends Serializable{

    int getPriority();
}
