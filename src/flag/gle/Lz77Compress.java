package flag.gle;

/**
 * Created by muni on 2019/12/11
 *
 * 原：    ABRA KEDABRA KADABRA
 压缩后: ABRA KED|tag|len|offset| KA|tag|len|offset
 Compress: ABRA KED[0xFE 4 7] [0xFE 5 5]
 (tag = 0xFE/254, len, offset)
 有压缩后的字符串，还原原来的。
 时间复杂度O(N)。tag就是一个标记，len是引用了多长，offset是这个字符串往前数多少个是同一个字符串。
 遇到0xFE说明遇到压缩的部分了，第一个是压缩的长度，第二个是压缩的offset，比如第一个case，从D开始往回offset到A，压缩的string是ABRA

 这个有一定的小trick，一个是会有地址偏移，一个是可以引用引用，如例子所示。要考虑引用的地址偏移.

 **follow up:** 原文中遇到tag怎么办.我的答案|tag|tag
 考官答案|tag|0, 压缩效率更好
 */
public class Lz77Compress {
}
