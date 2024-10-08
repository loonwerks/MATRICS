/**
 * Copyright (c) 2024, Collins Aerospace.
 * Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
 * including any software or models in source or binary form, as well as any drawings, specifications, 
 * and documentation (collectively "the Data"), to deal in the Data without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Data.
 * 
 * THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 * 
 * Generated by Xtext version 2.33.0.
 */
package com.collins.trustedmethods.matrics.soar.soar.util;

import com.collins.trustedmethods.matrics.soar.soar.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage
 * @generated
 */
public class SoarAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SoarPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SoarAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SoarPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SoarSwitch<Adapter> modelSwitch =
    new SoarSwitch<Adapter>()
    {
      @Override
      public Adapter caseSoarAnnexLibrary(SoarAnnexLibrary object)
      {
        return createSoarAnnexLibraryAdapter();
      }
      @Override
      public Adapter caseSoarAnnexSubclause(SoarAnnexSubclause object)
      {
        return createSoarAnnexSubclauseAdapter();
      }
      @Override
      public Adapter caseSoarProduction(SoarProduction object)
      {
        return createSoarProductionAdapter();
      }
      @Override
      public Adapter caseConditionSide(ConditionSide object)
      {
        return createConditionSideAdapter();
      }
      @Override
      public Adapter caseStateImpCondition(StateImpCondition object)
      {
        return createStateImpConditionAdapter();
      }
      @Override
      public Adapter caseCond(Cond object)
      {
        return createCondAdapter();
      }
      @Override
      public Adapter casePositiveCond(PositiveCond object)
      {
        return createPositiveCondAdapter();
      }
      @Override
      public Adapter caseCondForOneId(CondForOneId object)
      {
        return createCondForOneIdAdapter();
      }
      @Override
      public Adapter caseAttrValueTest(AttrValueTest object)
      {
        return createAttrValueTestAdapter();
      }
      @Override
      public Adapter caseValueTest(ValueTest object)
      {
        return createValueTestAdapter();
      }
      @Override
      public Adapter caseTest(Test object)
      {
        return createTestAdapter();
      }
      @Override
      public Adapter caseDisjunctionTest(DisjunctionTest object)
      {
        return createDisjunctionTestAdapter();
      }
      @Override
      public Adapter caseSingleTest(SingleTest object)
      {
        return createSingleTestAdapter();
      }
      @Override
      public Adapter caseRelationalTest(RelationalTest object)
      {
        return createRelationalTestAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseActionSide(ActionSide object)
      {
        return createActionSideAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter casePrint(Print object)
      {
        return createPrintAdapter();
      }
      @Override
      public Adapter caseFuncCall(FuncCall object)
      {
        return createFuncCallAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseAttrValueMake(AttrValueMake object)
      {
        return createAttrValueMakeAdapter();
      }
      @Override
      public Adapter caseVariableorSymConstant(VariableorSymConstant object)
      {
        return createVariableorSymConstantAdapter();
      }
      @Override
      public Adapter caseConstant(Constant object)
      {
        return createConstantAdapter();
      }
      @Override
      public Adapter caseValueMake(ValueMake object)
      {
        return createValueMakeAdapter();
      }
      @Override
      public Adapter casePrefSpecifier(PrefSpecifier object)
      {
        return createPrefSpecifierAdapter();
      }
      @Override
      public Adapter caseStateImpCond(StateImpCond object)
      {
        return createStateImpCondAdapter();
      }
      @Override
      public Adapter caseConjuctiveTest(ConjuctiveTest object)
      {
        return createConjuctiveTestAdapter();
      }
      @Override
      public Adapter caseSimpleTest(SimpleTest object)
      {
        return createSimpleTestAdapter();
      }
      @Override
      public Adapter caseMultiValueTest(MultiValueTest object)
      {
        return createMultiValueTestAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseAnnexLibrary(AnnexLibrary object)
      {
        return createAnnexLibraryAdapter();
      }
      @Override
      public Adapter caseModalElement(ModalElement object)
      {
        return createModalElementAdapter();
      }
      @Override
      public Adapter caseAnnexSubclause(AnnexSubclause object)
      {
        return createAnnexSubclauseAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SoarAnnexLibrary <em>Annex Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarAnnexLibrary
   * @generated
   */
  public Adapter createSoarAnnexLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause <em>Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause
   * @generated
   */
  public Adapter createSoarAnnexSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction <em>Production</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarProduction
   * @generated
   */
  public Adapter createSoarProductionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ConditionSide <em>Condition Side</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ConditionSide
   * @generated
   */
  public Adapter createConditionSideAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.StateImpCondition <em>State Imp Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.StateImpCondition
   * @generated
   */
  public Adapter createStateImpConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Cond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Cond
   * @generated
   */
  public Adapter createCondAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.PositiveCond <em>Positive Cond</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.PositiveCond
   * @generated
   */
  public Adapter createPositiveCondAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.CondForOneId <em>Cond For One Id</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.CondForOneId
   * @generated
   */
  public Adapter createCondForOneIdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.AttrValueTest <em>Attr Value Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.AttrValueTest
   * @generated
   */
  public Adapter createAttrValueTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ValueTest <em>Value Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ValueTest
   * @generated
   */
  public Adapter createValueTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Test <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Test
   * @generated
   */
  public Adapter createTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.DisjunctionTest <em>Disjunction Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.DisjunctionTest
   * @generated
   */
  public Adapter createDisjunctionTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SingleTest <em>Single Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SingleTest
   * @generated
   */
  public Adapter createSingleTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.RelationalTest <em>Relational Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.RelationalTest
   * @generated
   */
  public Adapter createRelationalTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ActionSide <em>Action Side</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ActionSide
   * @generated
   */
  public Adapter createActionSideAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Print <em>Print</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Print
   * @generated
   */
  public Adapter createPrintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.FuncCall <em>Func Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.FuncCall
   * @generated
   */
  public Adapter createFuncCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.AttrValueMake <em>Attr Value Make</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.AttrValueMake
   * @generated
   */
  public Adapter createAttrValueMakeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.VariableorSymConstant <em>Variableor Sym Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.VariableorSymConstant
   * @generated
   */
  public Adapter createVariableorSymConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Constant
   * @generated
   */
  public Adapter createConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ValueMake <em>Value Make</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ValueMake
   * @generated
   */
  public Adapter createValueMakeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.PrefSpecifier <em>Pref Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.PrefSpecifier
   * @generated
   */
  public Adapter createPrefSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.StateImpCond <em>State Imp Cond</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.StateImpCond
   * @generated
   */
  public Adapter createStateImpCondAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ConjuctiveTest <em>Conjuctive Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ConjuctiveTest
   * @generated
   */
  public Adapter createConjuctiveTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SimpleTest <em>Simple Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SimpleTest
   * @generated
   */
  public Adapter createSimpleTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.MultiValueTest <em>Multi Value Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.MultiValueTest
   * @generated
   */
  public Adapter createMultiValueTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexLibrary <em>Annex Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexLibrary
   * @generated
   */
  public Adapter createAnnexLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalElement <em>Modal Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ModalElement
   * @generated
   */
  public Adapter createModalElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexSubclause
   * @generated
   */
  public Adapter createAnnexSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //SoarAdapterFactory
