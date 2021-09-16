package com.base.newPeaceSystemBuild.repository

import com.base.newPeaceSystemBuild.vo.client.Funeral
import com.base.newPeaceSystemBuild.vo.standard.Flower
import com.base.newPeaceSystemBuild.vo.standard.FlowerTribute
import com.base.newPeaceSystemBuild.vo.vendor.Order
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update


@Mapper
interface VendorRepository {

    @Select(
    """
        SELECT * 
        FROM FLOWER
    """
    )
    fun getFlowers(): List<Flower>

    @Update(
        """
            UPDATE funeral 
            SET flowerId = #{flowerId} 
            WHERE id = #{funeralId};
        """
    )
    fun modifyFuneralIntoFlowerId(funeralId:Int, flowerId: Int)

    @Select(
        """
            SELECT * 
            FROM funeral 
            WHERE id = #{funeralId};
        """
    )
    fun getFuneralById(funeralId: Int): Funeral?

    @Select(
        """
            SELECT *
            FROM `flower`
            WHERE id = #{flowerId}
        """
    )
    fun getFlowerById(flowerId: Int): Flower?

    @Select(
        """
            SELECT LAST_INSERT_ID();
        """
    )
    fun getLastInsertId(): Int

    @Insert(
        """
            INSERT INTO `order`
            SET regDate = NOW(),
            updateDate = NOW(),
            clientId = #{clientId},
            directorMemberId = #{directorMemberId},
            roleCategoryId = #{roleCategoryId},
            standardId = #{flowerId}
        """
    )
    fun insertIntoOrder(clientId:Int, directorMemberId: Int, roleCategoryId: Int, flowerId: Int)

    @Update(
        """
            UPDATE `order` SET
            vendorMemberId = #{vendorMemberId},
            orderStatus = #{orderStatus}
            WHERE directorMemberId = #{directorMemberId}
            AND roleCategoryId = #{roleCategoryId}
        """
    )
    fun modifyOrderIntoVendorMemberIdAndOrderStatusByDirectorMemberIdAndRoleCategoryId(vendorMemberId: Int, directorMemberId: Int, roleCategoryId: Int, orderStatus: Boolean)

    @Select(
        """
            <script>
            SELECT 
            O.*,
            C.id AS `extra__clientId`,
            C.regDate AS `extra__clientRegDate`,
            C.updateDate AS `extra__clientUpdateDate`,
            C.deceasedName AS `extra__deceasedName`,
            C.relatedName AS `extra__relatedName`,
            C.cellphoneNo AS `extra__cellphoneNo`,
            C.location AS `extra__location`,
            C.address AS `extra__address`,
            C.bank AS `extra__bank`,
            C.accountNum AS `extra__accountNum`,
            M.name AS `extra__directorName`,
            M.cellphoneNo AS `extra__directorCellphoneNo`,
            <if test="roleCategoryId == 1">
                F.name AS `extra__name`,
                F.retailPrice AS `extra__retailPrice`
            </if>
            <if test="roleCategoryId == 2">
                P.name AS `extra__name`,
                P.retailPrice AS `extra__retailPrice`
            </if>
            FROM `order` AS O
            LEFT JOIN `client` AS C
            ON O.clientId = C.id
            LEFT JOIN `member` AS M
            ON O.directorMemberId = M.id
            <if test="roleCategoryId == 1">
                LEFT JOIN `flower` AS F
                ON O.standardId = F.id
            </if>
            WHERE vendorMemberId = #{vendorMemberId}
            AND orderStatus = #{orderStatus}
            AND completionStatus = #{completionStatus}
            AND roleCategoryId = #{roleCategoryId}
            </script>
        """
    )
    fun getOrdersByVendorMemberIdAndOrderStatus(vendorMemberId: Int, roleCategoryId: Int, orderStatus: Boolean, completionStatus: Boolean): List<Order>

    @Select(
        """
            SELECT * 
            FROM `order`
            WHERE clientId = #{clientId}
        """
    )
    fun getOrderByClientId(clientId: Int): Order?

    @Select(
        """
            SELECT * 
            FROM `order`
            WHERE clientId = #{clientId}
            AND roleCategoryId = #{roleCategoryId}
        """
    )
    fun getOrderByClientIdAndRoleCategoryId(clientId: Int, roleCategoryId: Int): Order?

    @Select(
        """
            UPDATE `order`
            SET completionStatus = #{completionStatus}
            WHERE vendorMemberId = #{vendorMemberId}
            AND clientId = #{clientId}
        """
    )
    fun modifyOrderIntoCompleteStatusByVendorMemberIdAndClientId(vendorMemberId: Int, clientId: Int, completionStatus: Boolean)

    @Select(
        """
            SELECT * 
            FROM flowerTribute
        """
    )
    fun getFlowerTributes(): List<FlowerTribute>

    @Insert(
        """
            INSERT INTO flowerTributeOrder
            SET regDate = NOW(),
            updateDate = NOW(),
            orderId = #{orderId},
            bunchCnt = #{bunchCnt},
            packing = #{packing}
        """
    )
    fun insertIntoFlowerTributeOrder(orderId: Int, bunchCnt: Int, packing: Boolean)

    @Update(
        """
            UPDATE funeral 
            SET flowerTributeId = #{flowerTributeId} 
            WHERE id = #{funeralId};
        """
    )
    fun modifyFuneralIntoFlowerTributeId(funeralId: Int, flowerTributeId: Int)

    @Select(
        """
            SELECT *
            FROM `flowerTribute`
            WHERE id = #{flowerTributeId} 
        """
    )
    fun getFlowerTributeById(flowerTributeId: Int): FlowerTribute?

    @Select(
        """
            SELECT 
            O.*,
            FTO.bunchCnt AS `extra__bunchCnt`,
            FTO.packing AS `extra__packing`
            FROM `order` AS O
            LEFT JOIN flowerTributeOrder AS FTO
            ON O.id = FTO.orderId
            WHERE O.directorMemberId = #{directorMemberId}
            AND FTO.bunchCnt IS NOT NULL
            AND FTO.packing IS NOT NULL
        """
    )
    fun getFlowerTributeOrderByDirectorMemberId(directorMemberId: Int): Order


}