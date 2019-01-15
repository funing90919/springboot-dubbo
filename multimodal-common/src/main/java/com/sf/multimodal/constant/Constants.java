package com.sf.multimodal.constant;

/**
 * Created by Jacky on 2019/1/15 14:16
 */
public class Constants {

    public enum GoodsNumUnitEnum {
        /**
         * 商品数量单位1件；2个；3台；4部...
         */
        GOODS_NUM_UNIT_1(1),
        GOODS_NUM_UNIT_2(2),
        GOODS_NUM_UNIT_3(3),
        GOODS_NUM_UNIT_4(4);

        private final int value;

        private GoodsNumUnitEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum PaymentStatusEnum {
        /**
         * 支付状态0未支付，1已支付
         */
        PAYMENT_STATUS_NO(0),
        PAYMENT_STATUS_YES(1);

        private final int value;

        private PaymentStatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
